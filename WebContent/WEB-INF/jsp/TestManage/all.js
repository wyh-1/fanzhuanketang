function check(){
	if (document.form1.Text.value=="")
    {window.alert("the Text can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.Type.value=="")
    {window.alert("the Type can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.TestKey.value=="")
    {window.alert("the TestKey can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.Score.value=="")
    {window.alert("the Score can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.CreateTime.value=="")
    {window.alert("the CreateTime can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.TeacherID.value=="")
    {window.alert("the TeacherID can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	if (document.form1.CourseID.value=="")
    {window.alert("the CourseID can't be null!");
     document.form1.bookname.focus();
	  return false;
    }
	return true;
}