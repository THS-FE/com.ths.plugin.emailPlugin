var exec = require('cordova/exec');

module.exports = {
//初始化，启动邮箱
startEmail:function(arg0, success, error) {
    cordova.exec(success, error, "ThsEmailPlugin", "startEmail", arg0);
}

};
