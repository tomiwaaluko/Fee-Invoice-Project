# Fee-Invoice-Project
Developed a fee invoice application for Valence College that calculates student fees based on residency, course load, and eligibility for discounts. The application includes features for student and course management, such as adding students, printing invoices, and managing labs, highlighting strong object-oriented programming skills.




The purpose of this project is to create a fee invoice application for students attending Valence College, a college in the State of Florida. There are two types of students: graduate (PhD and MS) and undergraduate. An out-of-state undergraduate student pays twice the tuition of a Florida-resident undergraduate student (all pay the same health and id fees of $35). A graduate student is either an PhD or an MS student. PhD students don’t take any courses, but each has an advisor and a research subject. Each Phd student must supervise at least one lab. A lab can be supervised by more than one PhD student (Labs can’t be supervised by undergraduate students nor MS students). MS students can only take graduate courses, and undergraduate students can only take undergraduate courses. 

At this time, Valence College offers the following list of classes/labs: (Used in the project as lect.txt). 

89745,COT6578,Advanced Computer theory,Graduate,F2F,PSY-108,No,4
66636,DIG2158,Introduction to Digital Systems,Undergraduate,Online,3
32658,COT6578,Advanced Computer theory,Graduate,Mixed,LPS-35,No,4
69745,COP5698,Programming Languages,Graduate,F2F,CB2-122,YES,5
19745,MSB-123
36598,PSY-100 
20315,HSA1-116
56980,CDL2587,Introduction to Computers,Undergraduate,F2F,MSB-116,YES,4
98123,RMA-008
91862,RMA-008
95315,RMA-008
36636,SOF2058,Introduction to Software,Undergraduate,Online,3
12658,LOG5578,Logic and Proof,Graduate,Mixed,LPS-35,Yes,3
98103,CMA-008
90862,RMA-013
95310,RMA-028
60045,COP5690,Programming Languages II,Graduate,F2F,CB2-120,YES,4
19005,MSB-103
30008,PSY-107 
20300,HSA1-16
51180,CDL2587,Introduction to Computers,Undergraduate,online,3
36637,SOF2058,Introduction to Software,Undergraduate,Online,3
22658,LOG5578,Logic and Proof,Graduate,F2F,LPS-35,Yes,3
98000,CMA-008
94442,RMA-013
56510,RMA-028
69970,GOL1091, Introduction to AI, Graduate, Online,1 

An explanation on how to read the list above is provided at the end of this document.

This hierarchy is a great visual representation when I was coding the classes.

*pictured in the png within the repository*

Example of an MS student:
	Name: Emily Jones 
	Id:em1254
	Courses taken: LOG5578
Example of an PhD student:
	Name: Zaydoun BenSellam
	Id: zb5954
	Advisor: Gary Richarson  
	Research Subject: Fuzzy Topology
	Lab supervised: 20300,94442

Note that it costs, for undergraduate Florida residents, 120.25 dollars per credit hour, and all MS students pay $300 per credit hour. in addition to the $35.00 charged for health and id services. Undergraduate Students with gpa of 3.5 or higher receive a discount of 25% when the total payments exceed $500. PhD students pay a separate research fee of $700. Phd students who supervise two labs are given a discount of 50%, and PhD Students supervising 3 labs or more pay the health and id fees only.

A fee invoice for an undergraduate student should look like

VALENCE COLLEGE
ORLANDO FL 10101
			---------------------
Fee Invoice Prepared for Student:
KJ2959-KARIM JONES           (Karim, a FL resident, has gpa higher than 3.5 gpa)

1 Credit Hour = $120.25

			CRN	CR_PREFIX	CR_HOURS			
56980	CDL2587	4		$ 481.00
36637 SOF2058	3		$ 360.75	

		Health & id fees	$ 35.00

--------------------------------------
					$ 876.75
				     -$ 219.18
				    ----------
		TOTAL PAYMENTS 	$ 657.56	



A fee invoice for an MS student should look like

VALENCE COLLEGE
ORLANDO FL 10101
			---------------------

Fee Invoice Prepared for Student:
KA2959-ERICKA JUNAID			

1 Credit Hour = $300.00				

			CRN	CR_PREFIX	CR_HOURS			
69970	GOL1091	1		$ 300.00

		Health & id fees	$ 35.00

--------------------------------------
	TOTAL PAYMENTS		$ 335.00
				     
				    
A fee invoice for an PhD student should look like

VALENCE COLLEGE
ORLANDO FL 10101
			---------------------

Fee Invoice Prepared for Student:
JO2978-John JUNAID
John’s research subject:Climate Change. John supervises three labs or more.
			RESEARCH				
Climate Change			$ -700.00

		Health & id fees	$ 35.00

--------------------------------------
		Total Payments	$ 35.00


----------------------------------------


Some guidelines and constraints for this project


1)	In addition to the ProjectDriver class, I will need to add all the classes shown on the inheritance hierarchy shown above. (Student, GraduateStudent, UndergraduateStudent, MsStudent and PhdStudent). Both Student and GraduateStudent are to be made abstract. The Student class must contain the abstract method: 
abstract public void printInvoice();

Additional classes may be added. See 6) below

2)	The abstract method, printInvoice, is to be overridden to display the right fee invoice, depending on the type of the student. Data fields of all classes are to be made private.

3)	I may use any data structure to store my objects. I could use an array, array list, LinkedList … etc. 

4)	My code should handle ALL exceptions. The bottom line is that my code should NOT crash! 

5)	My code must have a user-defined exception class called IdException that handles the ids entered by the user. Note that an person’s ID must be of the form LetterLetterDigitDigitDigitDigit like er7894. No two persons can have the same id. An exception of type IdException is thrown when the id entered is either duplicated or in wrong format. I could handle it in any way that I see fit!

6)	This project requires additional code to manage the courses and labs. I need to note that the Java classes and data stuctures needed to manage the courses/Labs is left to me (the student) to decide on… 

7)	The main menu of my programs has two options: Student Management and Class Management. The Student Management option shows a sub-menu that allows the user to:

a.	add a student
b.	search for a student by id
c.	delete a student
d.	print the fee invoice of a student by id.
e.	Print all students(Just the name) grouped by type. PhD students together, MS students together and Undergraduate students together. Something like:

PhD Students
------------
-	Zydoun BenSellam
-	Erica Belksiri

MS Students
------------
-	Caleb Sidi Kacem
-	Erika Jones
-	Walid Wali

Undergraduate Students
------------
-	Ed Johnson
-	Willian Jones
-	Kirby Sons

The Class Management option allows:
a)	search for a class or lab using the class/lab number
b)	delete a class (this requires the deletion of all the labs associated with that class
c)	add a lab to a class when applicable. More information on classes and labs is given at the end of this document…
(I could add the option that displays the list of classes and labs to check my code)



Sample Run: Assume that the user enters a valid menu option (for all the menus)

---------------------------------------------------

			Main Menu
				
			1 : Student Management
			2 : Course Management
			0 : Exit
			
				Enter your selection: 2 

-----------------
 			
			Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


			Enter your selection: A 

			Enter the Class/Lab Number: 98103
			
Lab for [ 12658,LOG5578,Logic and Proof ]
Lab Room CMA-008
	

Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


			Enter your selection: A
			
Enter the Class/Lab Number: 12658
[ 12658,LOG5578,Logic and Proof ]









Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


			Enter your selection: A

Enter the Class/Lab Number: 12345
[ ]


Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


			Enter your selection: B

Enter the Class/Lab Number: 12658
[ 12658,LOG5578,Logic and Proof ] deleted!

(don’t forget to update lec.txt!)

Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


Enter your selection: C

	Enter Lab or Lecture: Lab
	Enter the Lecture Number to a Lab to: 12658
	No Such Lecture Exists!








Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


Enter your selection: C

Enter Lab or Lecture: Lecture
	Enter the Lecture Number to a Lab to: 66666
	66666 is valid. Enter the rest of the information:
GOL1091, Introduction to AI, Graduate, Online,1
(Assume that the user enter valid information here)

 Lecture added successfully!
 	(don’t forget to update lec.txt!)


Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


Enter your selection: C

Enter Lab or Lecture: Lecture
	Enter the Lecture Number to a Lab to: 66667
	66667 is valid. Enter the rest of the information:
GOL1091, Introduction to AI, F2F,LPT-35,No,1


	Course Management Menu:

			Choose one of:

A - Search for a class or lab using the class/lab number
B - delete a class 
C - Add a lab to a class 
X – Back to main menu


Enter your selection: x (treated as X)





---------------------------------------------------
Main Menu
				
			1 : Student Management
			2 : Course Management
			0 : Exit
			
				Enter your selection: 1 

-----------------

Student Management Menu:

			Choose one of:

A - Search add a student
B - Delete a Student 
C – Print Fee Invoice 
D – Print List of Students
X – Back to Main Menu


Enter your selection: D

PhD Students
------------
-	Zydoun BenSellam
-	Erica Belksiri

MS Students
------------
-	Caleb Sidi Kacem
-	Erika Jones
-	Walid Wali

Undergraduate Students
------------
-	Ed Johnson
-	Willian Jones
-	Kirby Sons
 
Student Management Menu:

			Choose one of:

A - Search add a student
B - Delete a Student 
C – Print Fee Invoice 
D – Print List of Students
X – Back to Main Menu


Enter your selection: A


Enter Student’s ID: ew44-yye
Invalid id format or ID already exists
Try again later!

Student Management Menu:

			Choose one of:

A - Search add a student
B - Delete a Student 
C – Print Fee Invoice 
D – Print List of Students
X – Back to Main Menu


Enter your selection: A

Enter Student’s ID: zb5954
Student Type (PhD, MS or Undergrad): PhD
Enter Remaining information 

Zaydoun BenSellam|Gary Richardson|Fuzzy Toplology|20300,94442
	(No need to check anything: we assume that the user enter valid information, including lab numbers!)
		
		[ Zaydoun BenSellam ] added!

Student Management Menu:

			Choose one of:

A - Search add a student
B - Delete a Student 
C – Print Fee Invoice 
D – Print List of Students
X – Back to Main Menu


Enter your selection: X

---------------------------------------------------
Main Menu
				
			1 : Student Management
			2 : Course Management
			0 : Exit
			
				Enter your selection: 0

			
Take Care!
(The Tas will check Lec.txt to make sure that everything is updated in Lec.txt. No need to do anything with the students data)

 




Understanding the structure of lec.txt

Each line in lec.txt represents a class being offered at Valence College.

A class is either a lecture (LEC) or a lab (LAB). A lecture (LEC) is characterized by:
-	Class Number (CN), a unique five-digit number assigned for each lecture/lab 
-	Prefix (like COP3330)
-	Title (like Introduction to Object Oriented Programming)
-	Location (like CB 2-201) 
-	Graduate or undergraduate. 
-	Modality: Online, Face-to-Face(F2F) or Mixed Mode (Mixed)
-	If Modality is F2F or Mixed, then the following entry is the location where that class is taking place. The next YES/NO field is to specify whether that class has a lab or not. When a non-online class has a lab, the labs are listed right after. See below for more information about the labs. Online sections don’t have labs.
-	Credit hours is the last field of any lecture. 


Examples:
89745,COT6578,Advanced Computer theory,Graduate,F2F,PSY-108,No,4
32658,COT6578,Advanced Computer theory,Graduate,Mixed,LPS-35,No,4

That means that the college offers two sections of COT6578, one is F2F and the other is online. Both of those sections don’t have labs.

When a lecture has a lab, the labs’ information is provided right after the lecture information

Example:
69745,COP5698, Programming Languages,Graduate,F2F,CB2-122,YES,4
19745,MSB-123
36598,PSY-100 
20315,HSA1-116

That means the COP5698 with cn 69745 has three labs. 19745, 36598  and 20315 are the cns of the labs. MSB-123,  PSY-100 and HSA1-116 are the building-room numbers where those labs are scheduled to take place.

Note that if the Modality is Online, then the line of the lec.txt has the form:
CN,PREFIX,LECTURE TITLE,GRADUTE/UNDERGRADUTE/ONLINE,CREDIT HOURS

Example:
36636,SOF2058,Introduction to Software,Undergraduate,Online,3

