<script>
    String.prototype.format = function (args) {
        var result = this;
        if (arguments.length > 0) {
            if (arguments.length == 1 && typeof (args) == "object") {
                for (var key in args) {
                    if (args[key] != undefined) {
                        var reg = new RegExp("({" + key + "})", "g");
                        result = result.replace(reg, args[key]);
                    }
                }
            }
            else {
                for (var i = 0; i < arguments.length; i++) {
                    if (arguments[i] != undefined) {
                        var reg = new RegExp("({)" + i + "(})", "g");
                        result = result.replace(reg, arguments[i]);
                    }
                }
            }
        }
        return result;
    }

    $(function(){
        $('#signin').on('click',function(){
            var $email = $('#email'),
                emailVal = $.trim($email.val()),
                $password = $('#password'),
                passwordVal = $.trim($password.val());

            if(emailVal.length == 0){
                alert('用户名不能为空');
                $email.focus();
                return false;
            }

            if(passwordVal.length == 0){
                alert('密码不能为空');
                $password.focus();
                return false;
            }

            return true;
        })
    });
</script>