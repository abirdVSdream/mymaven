<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<SCRIPT language="javascript">  
 /*************************************************************************************************************** 
  * 文 件 名：selectListTools.js  
  * 文件描述：关于list列表框的一些工具方法 
  * 主要方法： 
  *          1， moveUp(oSelect,isToTop) －－－－－－－－－－－－ 向上移动一个list列表框的选中项目， 
 *                                                                可以支持多选移动，可以设置是否移动到顶层 
  *          2， moveDown(oSelect,isToBottom)－－－－－－－－－－ 向下移动一个list列表框的选中项目， 
  *                                                                可以支持多选移动，可以设置是否移动到底层 
  *          3， moveSelected(oSourceSel,oTargetSel) －－－－－－ 在两个列表框之间转移数据 
  *          4， moveAll(oSourceSel,oTargetSel)－－－－－－－－－ 转移两个列表框之间的全部数据 
  *          5， deleteSelectItem(oSelect) －－－－－－－－－－－ 删除所选的项目 
  *  
 ****************************************************************************************************************/  
    
/** 
  * 使选中的项目上移 
  * 
  * oSelect: 源列表框 
  * isToTop: 是否移至选择项到顶端，其它依次下移， 
  *          true为移动到顶端，false反之，默认为false 
  */  
 
/** 
  * 移动select的部分内容,必须存在value，此函数以value为标准进行移动 
  * 
  * oSourceSel: 源列表框对象  
  * oTargetSel: 目的列表框对象 
  */  
  function subsss(){
	  var a="http://pic.shopex.cn/pictures/gimages/4a06fb262ad25846.jpg";
	  var c=a.substr(7);
	  var b= "pictures";
	  alert(b);
	  var d=c.substr(b);
	  alert(d);
	  }
  //alert(document.all.left);
 function moveSelected(oSourceSel,oTargetSel)  
 {  
     //建立存储value和text的缓存数组  
    var arrSelValue = new Array();  
    var arrSelText = new Array();  
     //此数组存贮选中的options，以value来对应  
     var arrValueTextRelation = new Array();  
     var index = 0;//用来辅助建立缓存数组  
       
     //存储源列表框中所有的数据到缓存中，并建立value和选中option的对应关系  
     for(var i=0; i<oSourceSel.options.length; i++)  
     {  
         if(oSourceSel.options[i].selected)  
        {  
            //存储  
            arrSelValue[index] = oSourceSel.options[i].value;  
            arrSelText[index] = oSourceSel.options[i].text;  
            //建立value和选中option的对应关系  
             arrValueTextRelation[arrSelValue[index]] = oSourceSel.options[i];  
            index ++;  
         }  
     }  
       
     //增加缓存的数据到目的列表框中，并删除源列表框中的对应项  
    for(var i=0; i<arrSelText.length; i++)    
     {  
         //增加  
        var oOption = document.createElement("option");  
         oOption.text = arrSelText[i];  
         oOption.value = arrSelValue[i];  
        oTargetSel.add(oOption);  
        //删除源列表框中的对应项  
         oSourceSel.removeChild(arrValueTextRelation[arrSelValue[i]]);  
     }  
 }  
/** 
 * 移动select的整块内容 
  * 
  * oSourceSel: 源列表框对象  
  * oTargetSel: 目的列表框对象 
  */  

/** 
  * 删除选定项目 
  * 
 * oSelect: 源列表框对象  
  */  

//js文件完毕  
 </SCRIPT>  
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">  
 <BODY style="font-size:12px" mce_style="font-size:12px">  
 <FORM name="form1" method="post" action="">  
  <SELECT name="left" size="10" id="select" multiple style="width:100px; ">  
     <OPTION value="aaaaa">aaaaa</OPTION>  
     <OPTION value="bbbbb">bbbbb</OPTION>  
     <OPTION value="ccccc">ccccc</OPTION>  
  </SELECT>  
  <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value=">>>" onClick="moveSelected(document.all.left,document.all.right)">  
   <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value="<<<" onClick="moveSelected(document.all.right,document.all.left)">  
   <SELECT name="right" size="10" id="select" multiple style="width:100px; ">  
    <OPTION value="ddddd">ddddd</OPTION>  
   <OPTION value="eeeee">eeeee</OPTION>  
    <OPTION value="fffff">fffff</OPTION>  
     <OPTION value="ggggg">ggggg</OPTION>  
     <OPTION value="hhhhh">hhhhh</OPTION>  
     <OPTION value="iiiii">iiiii</OPTION>  
  </SELECT>  
  



  
   <DIV style="background-color:#CCCCCC;padding:2px" mce_style="background-color:#CCCCCC;padding:2px">  
   <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value="上移一格" onClick="moveUp(document.all.right);moveUp(document.all.left)">  
   <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value="下移一格" onClick="moveDown(document.all.right);moveDown(document.all.left)">  
   <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value="上移到顶"   
 onClick="moveUp(document.all.right,true);moveUp(document.all.left,true)">  
  <INPUT style="border:1px solid black " mce_style="border:1px solid black " type="button" value="下移到顶"   
 onClick="moveDown(document.all.right,true);moveDown(document.all.left,true);">  （支持多选移动）  
   </DIV>  
   <BR><BR>  
  <DIV style="background-color:#CCCCCC; padding:5px; width:100%; position:relative">  
  右移：<INPUT type="radio" name="ifAll" value="right" checked> 
  
 左移：<INPUT type="radio" name="ifAll" value="left">

  
  <INPUT type="button" value="移动全部" style="border:1px solid black " mce_style="border:1px solid black " onClick="subsss()">   
  </DIV>  
   

  
   <DIV style="background-color:#CCCCCC; padding:5px" mce_style="background-color:#CCCCCC; padding:5px">  
       <INPUT type="button" value=" 删 除 " style="border:1px solid black " mce_style="border:1px solid black "   
 onClick="deleteSelectItem(document.all.left);deleteSelectItem(document.all.right)">  
   
   </FORM>  
 </BODY>  
 <SCRIPT language="javascript">  
 function judgeMove()  
 {  
     var arrRadio = document.all.ifAll;  
     var valOfRadio;  
     for(var i=0; i<arrRadio.length; i++)  
     {  
         if(arrRadio[i].checked)  
         {  
             valOfRadio = arrRadio[i].value;  
             break;  
         }  
     }  
     if(valOfRadio == "left")  
         moveAll(document.all.right,document.all.left);  
     if(valOfRadio == "right")  
         moveAll(document.all.left,document.all.right);  
 }  
 </SCRIPT>  
</body>
</html>