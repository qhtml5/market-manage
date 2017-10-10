package cn.lmjia.market.core.service;

import cn.lmjia.market.core.trj.InvalidAuthorisingException;
import me.jiangcai.payment.PayableOrder;
import me.jiangcai.payment.exception.SystemMaintainException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 支付助手服务
 *
 * @author CJ
 */
public interface PayAssistanceService {

    /**
     * 发起支付
     *
     * @param openId  openId
     * @param request mvc请求
     * @param order   需支付订单
     * @param huabei  是否使用花呗支付
     * @return 视图
     * @throws SystemMaintainException
     */
    ModelAndView payOrder(String openId, HttpServletRequest request, PayableOrder order, boolean huabei) throws SystemMaintainException;

    /**
     * 发起投融家分期支付
     *
     * @param openId  openId
     * @param request mvc请求
     * @param order   需支付订单
     * @return 视图
     * @throws SystemMaintainException
     * @throws InvalidAuthorisingException 如果按揭码无效
     */
    ModelAndView payOrder(String openId, HttpServletRequest request, PayableOrder order, String authorising
            , String idNumber) throws SystemMaintainException, InvalidAuthorisingException;

    /**
     * 校验按揭码
     *
     * @param authorising 按揭码
     * @param idNumber    身份证
     * @throws InvalidAuthorisingException 如果按揭码无效
     */
    void checkAuthorising(String authorising, String idNumber) throws InvalidAuthorisingException;
}
