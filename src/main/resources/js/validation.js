
function validate(frm){
	  alert("123");
	//empty  error messages
	document.getElementById("contactNameErr").innerHTML="";
	document.getElementById("contactNumErr").innerHTML="";
	document.getElementById("emailErr").innerHTML="";
	
	//read from data 
	 let name=frm.contactName.value;
	 let loc=frm.contactNumber.value;
	 let page=frm.contactEmail.value;
	 let flag=false;

	 //client side form validations
	 if(name==""){
		 document.getElementById("contactNameErr").innerHTML="<b> contactName name is mandatory (client side)</b>";
		 //frm.patName.focus();
		 flag=true;
	 }
	 
	 if(loc==""){
		 document.getElementById("contactNumErr").innerHTML="<b> contactnumber  is mandatory(client side)</b>";
		 //frm.location.focus();
		flag=true;
	 }
	 if(page==""){
		 document.getElementById("emailErr").innerHTML="<b>  email is mandatory(client side)</b>";
		 //frm.age.focus();
		flag=true;
	 }
	 
	 // change  custflag value to "yes" indicating client side validations are done
	 
	 frm.custflag.value="yes";
	 
	 alert("custflag isss"+custflag);
	 
	  if(flag)
		  return false;
	  else
		  	return true;
}//function

