package com.ths.plugin.emailPlugin;
import android.content.ComponentName;
import android.content.Intent;
import com.fsck.k9.activity.Accounts;
import com.fsck.k9.activity.MessageCompose;
import com.fsck.k9.activity.setup.ThsAccountSetup;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import cn.com.sc.mobile.affairs.MainActivity;

/**
 * 邮箱插件
 */
public class ThsEmailPlugin extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if(action.equals("startEmail")){ //启动邮箱
            String username = args.getString(0);
            String pwd = args.getString(1);
            String relName = args.getString(2);
            String ip = args.getString(3);
            this.startEmail(username,pwd,relName,ip,callbackContext);
        }else if(action.equals("sendEmail")){//发送邮件
            String email = args.getString(0);
            this.sendEmail(email);
        }
        return false;
    }
    /**
     * 启动邮箱
     * @param username 用户名
     * @param pwd 密码
     * @param relName 真实名字
     * @param ip 服务器地址
     */
    private void startEmail(String username,String pwd,String relName,String ip, CallbackContext callbackContext){
        Intent   intent=new Intent(cordova.getActivity(),Accounts.class);
        intent.putExtra(ThsAccountSetup.USER_NAME,username); //用户名
        intent.putExtra(ThsAccountSetup.PWD,pwd);//密码
                        intent.putExtra(ThsAccountSetup.REL_NAME,relName);//真实姓名
                        intent.putExtra(ThsAccountSetup.IP,ip);//邮箱服务地址
        cordova.getActivity().startActivity(intent);
        callbackContext.success("success");
    }

    /**
     * 发送邮件
     * @param email 邮箱地址
     */
    private void sendEmail(String email){
        String substring = email;
        if ("".equals(substring))
            return;
        Intent intent = new Intent(cordova.getActivity(),MessageCompose.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("email", substring);
        cordova.getActivity().startActivity(intent);
    }

}
