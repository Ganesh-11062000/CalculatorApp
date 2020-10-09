# CalculatorApp
This is a fully functional calculator app built in Android Studio (Java) which uses javax.script.ScriptEngine to evaluate mathematical expressions.
![alt text](https://github.com/Ganesh-11062000/CalculatorApp/blob/master/images/calculatorUI.PNG?raw=true)

# About the app layout
This app has two TextView widgets the first textView is to store the results computed and the second TextView dynamically changes to reflect the expression which the user is typing.

<img src="https://github.com/Ganesh-11062000/CalculatorApp/blob/master/images/ss.jpeg" width="25%">

# How to evaluate math expression?
### ScriptEngineManager manager = new ScriptEngineManager();
### ScriptEngine engine = manager.getEngineByName("js");
### Object result = engine.eval("4*5");

REPLACE the string in eval by any math expression given by user,
show a toast message in case of illegal expression in try catch block.
