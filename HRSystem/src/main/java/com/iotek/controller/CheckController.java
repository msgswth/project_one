package com.iotek.controller;

import com.iotek.model.Check;
import com.iotek.model.Reward;
import com.iotek.service.CheckService;
import com.iotek.service.EmployeeService;
import com.iotek.service.RewardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CheckController {
    @Resource
    private CheckService checkService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RewardService rewardService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    /*上班打卡*/
    @RequestMapping("checkOn")
    public String checkOn(Integer emp_id,String ch_start_time, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        /*得到上班打卡时间*/
        Date date=simpleDateFormat.parse(ch_start_time);
        java.sql.Date d=new java.sql.Date(date.getTime());
        /*得到打卡年月*/
        Check check = new Check();
        check.setEmp_id(emp_id);
        List<Check> checks = checkService.getCheckByEmpId(check);
        Check check1=null;
        if(checks!=null&&checks.size()!=0){
            check1=checks.get(checks.size()-1);
            if(sdf.format(check1.getCh_start_time()).equals(sdf.format(d))){
                out.print("<script>alert('你已经打过上班卡了')</script>");
                return "mainForEmp";
            }
        }
        /*生成上班打卡记录*/
        Check check2 = new Check();
        check2.setEmp_id(emp_id);
        check2.setCh_start_time(d);
        boolean b = checkService.addCheck(check);
        if(b){
            return "mainForEmp";
        }
        return "error";
    }

    /*下班打卡*/
    @RequestMapping("checkOff")
    public String checkOff(Integer emp_id,String ch_end_time, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        /*得到下班打卡时间*/
        Date date=simpleDateFormat.parse(ch_end_time);
        java.sql.Date d=new java.sql.Date(date.getTime());

        /*通过员工id查到这个员工最新的打卡记录*/
        Check check = new Check();
        check.setEmp_id(emp_id);
        List<Check> checks = checkService.getCheckByEmpId(check);
        Check check1=null;
        if(checks!=null&&checks.size()!=0){
            check1=checks.get(checks.size()-1);
            if(!sdf.format(check1.getCh_start_time()).equals(sdf.format(new Date()))){
                out.print("<script>alert('你今天还没打上班卡')</script>");
                return "mainForEmp";
            }else if(check1.getCh_end_time()!=null){
                out.print("<script>alert('你已经打过下班卡了')</script>");
                return "mainForEmp";
            }else {
                check1.setCh_end_time(d);
                if(checkService.updateCheck(check1)){

                    /*打完下班卡再生成奖惩记录*/
                    Reward re = new Reward();
                    Date checkOnTimeDate = check1.getCh_start_time();//上班时间
                    Date checkOffTimeDate = check1.getCh_end_time();//下班时间

                    String reason = "";//奖惩理由
                    Double money = 0.0;
                    if(checkOnTimeDate.getHours()-9>=0 && checkOnTimeDate.getHours()-9<2){
                        reason = reason+"迟到";
                        money = -50.0;
                    }else if(checkOnTimeDate.getHours()-9>2){
                        reason = reason+"迟到过久,旷工";
                        money = -300.0;
                    }

                    if(checkOffTimeDate.getHours()-18<0 && checkOffTimeDate.getHours()-18>-2){
                        reason = reason+"早退";
                        if(money==-300.0){
                            money=-300.0;
                        }
                        money =money-50.0;
                    }else if(checkOffTimeDate.getHours()-18<-2){
                        reason = reason+"早退过久,旷工";
                        money = -300.0;
                    }
                    re.setEmp_id(emp_id);
                    re.setR_reason(reason);
                    re.setR_date(new java.sql.Date(new Date().getTime()));
                    re.setR_money(money);

                    if(rewardService.addReward(re)){
                        return "mainForEmp";
                    }
                }
            }
        }else {//如果第一天打卡打的是下班卡
            out.print("<script>alert('你今天还没打上班卡')</script>");
            return "mainForEmp";
        }
        return "error";
    }

    @RequestMapping("getCheck")
    protected String getCheck(Check check, HttpSession session)throws Exception{
        List<Check> checks=checkService.getCheckByEmpId(check);
        session.setAttribute("checks",checks);
        return "getCheck";
    }
}
