package Project;

import defination.ContactList1;

public class Operartion<E>
{
    int sizea=0;
    int ind=0;
    ContactList1 <person> n=new ContactList1<>();
    ContactList1 <person> n1=new ContactList1();

    public void addContac(String a, String b, String c, String d)
    {
        person xy=new person(a,b,c,d);
        boolean t=n.add(xy);
        if(t==true)
        {
            System.out.println("contact added");
            sizea++;
        }
    }
    public person getContact(String s)
    {

        ContactList1.Node<person> bc=null;
        for(int i=0;i<sizea;i++)
        {
             bc=n.getNode(i);
            if(bc.getData().getFirstName().equals(s))
            {
               ind=i;
                break;

            }


        }
        return bc.getData();
    }
    public void getContactData(person bcd)
    {
        System.out.println(bcd.getFirstName());
        System.out.println(bcd.getLastName());
        System.out.println(bcd.getContactNumber());
        System.out.println(bcd.getEmailID());
    }
public void deletContact(String s)
{
    int hj=0;
    ContactList1.Node<person> bc=null;
    for(int i=0;i<sizea;i++)
    {
        bc=n.getNode(i);
        System.out.println(bc.getData().getFirstName()+ ""+ bc.getData().getLastName());
        if(bc.getData().getFirstName().equals(s))
        {
            hj=i;
            break;
        }
    }
    n.remove(hj);
    System.out.println("contact removed");
}
public void AddextraContact(String aa[])
{
    person n2=new person(aa);
    n1.add(n2);
    System.out.println("added");
}
public int IndexofContacts(String d)
{
    int uy=0;
    ContactList1.Node<person> abc=null;
    for(int i=0;i<sizea;i++)
    {
        abc=n.getNode(i);
        if(abc.getData().getFirstName().equals(d))
        {
            uy=i;
            break;
        }
    }
    return uy;
}
public void getExtraContact(String qw)
{
    int gh=IndexofContacts(qw);
   System.out.println(n1.getNode(gh).getData( ).getExtraContact());
}
public void printer()
{ ContactList1.Node<person> dc=null;
    for(int i=0;i<sizea;i++)
    {
       dc=n.getNode(i);
        getContactData(dc.getData());
    }
}
    private static class person {
        String FirstName;
        String LastName;
        String ContactNumber;
        String emailID;
        int arrl;
        String arr[]=new String[arrl];


        public person(String firstName, String lastName, String contactNumber, String emailID) {
            FirstName = firstName;
            LastName = lastName;
            ContactNumber = contactNumber;
            this.emailID = emailID;

        }
        public person(String[] arr)
        {
            this.arr=arr;
        }
        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getContactNumber() {
            return ContactNumber;
        }

        public void setContactNumber(String contactNumber) {
            ContactNumber = contactNumber;
        }

        public String getEmailID() {
            return emailID;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }

        public String getExtraContact()
        {
            String str=" ";
            int i = arr.length;
            for(int j=0;j<i;j++) {
                str=str+arr[j]+",";
            }
            return str;
        }
    }
}

