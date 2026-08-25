//23331A0581
public class Organization
{
    public static void main(String[] args)
    {
        Object[][] Employee={
            {"Emp No","Emp Name","Join Date","Designation Code","Department","Basic","HRA","IT"},
            {"1001","Ashish","01/04/2009","e","R&D",20000,8000,3000},
            {"1002","Sushma","23/08/2012","c","PM",30000,12000,9000},
            {"1003","Rahul","12/11/2008","k","Acct",10000,8000,1000},
            {"1004","Chahat","29/01/2013","r","Front Desk",12000,6000,2000},
            {"1005","Ranjan","16/07/2005","m","Engg",50000,20000,20000},
            {"1006","Suman","01/01/2000","e","Manufacturing",23000,900,4400},
            {"1007","Tanmay","12/06/2006","c","PM",29000,12000,10000}
        };
        Object[][] Designation={
            {"Designation Code","Designation","DA"},
            {"e","Engineer",20000},
            {"c","Consultant",32000},
            {"k","Clerk",12000},
            {"r","Receptionist",15000},
            {"m","Manager",40000}
        };
        switch(args[0])
        {
                case "1001":
                System.out.println("Emp No: "+Employee[1][0]);
                System.out.println("Emp Name: "+Employee[1][1]);
                System.out.println("Department: "+Employee[1][4]);
                System.out.println("Designation: "+Designation[1][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[1][5].toString())+Integer.parseInt(Employee[1][6].toString())+Integer.parseInt(Employee[1][7].toString())+Integer.parseInt(Designation[1][2].toString())));
                break;
                case "1002":
                System.out.println("Emp No: "+Employee[2][0]);
                System.out.println("Emp Name: "+Employee[2][1]);
                System.out.println("Department: "+Employee[2][4]);
                System.out.println("Designation: "+Designation[2][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[2][5].toString())+Integer.parseInt(Employee[2][6].toString())+Integer.parseInt(Employee[2][7].toString())+Integer.parseInt(Designation[2][2].toString())));
                break;
                case "1003":
                System.out.println("Emp No: "+Employee[3][0]);
                System.out.println("Emp Name: "+Employee[3][1]);
                System.out.println("Department: "+Employee[3][4]);
                System.out.println("Designation: "+Designation[3][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[3][5].toString())+Integer.parseInt(Employee[3][6].toString())+Integer.parseInt(Employee[3][7].toString())+Integer.parseInt(Designation[3][2].toString())));
                break;
                case "1004":
                System.out.println("Emp No: "+Employee[4][0]);
                System.out.println("Emp Name: "+Employee[4][1]);
                System.out.println("Department: "+Employee[4][4]);
                System.out.println("Designation: "+Designation[4][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[4][5].toString())+Integer.parseInt(Employee[4][6].toString())+Integer.parseInt(Employee[4][7].toString())+Integer.parseInt(Designation[4][2].toString())));
                break;
                case "1005":
                System.out.println("Emp No: "+Employee[5][0]);
                System.out.println("Emp Name: "+Employee[5][1]);
                System.out.println("Department: "+Employee[5][4]);
                System.out.println("Designation: "+Designation[5][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[5][5].toString())+Integer.parseInt(Employee[5][6].toString())+Integer.parseInt(Employee[5][7].toString())+Integer.parseInt(Designation[5][2].toString())));
                break;
                case "1006":
                System.out.println("Emp No: "+Employee[6][0]);
                System.out.println("Emp Name: "+Employee[6][1]);
                System.out.println("Department: "+Employee[6][4]);
                System.out.println("Designation: "+Designation[1][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[6][5].toString())+Integer.parseInt(Employee[6][6].toString())+Integer.parseInt(Employee[6][7].toString())+Integer.parseInt(Designation[1][2].toString())));
                break;
                case "1007":
                System.out.println("Emp No: "+Employee[7][0]);
                System.out.println("Emp Name: "+Employee[7][1]);
                System.out.println("Department: "+Employee[7][4]);
                System.out.println("Designation: "+Designation[2][1]);
                System.out.println("Salary: "+(Integer.parseInt(Employee[7][5].toString())+Integer.parseInt(Employee[7][6].toString())+Integer.parseInt(Employee[7][7].toString())+Integer.parseInt(Designation[2][2].toString())));
                break;
                default:
                System.out.println("There is no employee with empid : "+args[0]);   
        }
    }
}