var exec = require('cordova/exec');

module.exports = {
//初始化，启动邮箱
// String username = args.getString(0);
// String pwd = args.getString(1);
// String relName = args.getString(2);
// String ip = args.getString(3);
//使用：1、declare let cordova: any;
//      2、 cordova.plugins.ThsEmailPlugin.startEmail(['zhubohai@sthjt.sc.gov.cn', 'zhubohai', '朱波海', '182.148.109.15'], () => {});
   /**
     * 初始化，启动邮箱
     * @param email 邮箱地址
     */
    startEmail:function(arg0, success, error) {
        cordova.exec(success, error, "ThsEmailPlugin", "startEmail", arg0);
    },
       /**
         * 发送邮件
         * @param email 邮箱地址
         */
    sendEmail:function(arg0, success, error){
        cordova.exec(success, error, "ThsEmailPlugin", "sendEmail", arg0);
    }

};
