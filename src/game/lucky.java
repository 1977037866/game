package game;
import java.util.Scanner;

public class lucky {
	String[] regisName=new String[10];
	int[] regisPass=new int[10];
	int[] vipNo=new int[10];
	int member=0;
	
	public void register(){
		//�����û�һ��ע��һ������
		String continueToRegister=null;
		do{
			System.out.println("[���͸���ϵͳ>ע��]");	
		    System.out.println("����д����ע����Ϣ��");				 				 
			System.out.print("�û�����");
		    Scanner regis_name=new Scanner(System.in);
		    regisName[member]=regis_name.next();				
		    System.out.print("���룺");
		    Scanner regis_pass=new Scanner(System.in);
		    regisPass[member]=regis_pass.nextInt();				    
		    //�������1λ������Ϊ��Ա����
		    vipNo[member]=(int)(Math.random()*10);			     	 
		    System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");
	    	System.out.println("�û���\t����\t��Ա����");
	    	System.out.println(regisName[member]+"\t"+regisPass[member]+"\t"+vipNo[member]);
	    	member++;
	    	System.out.print("����ע���𣿣�y/n��");
	    	Scanner input_1=new Scanner(System.in);
	    	continueToRegister=input_1.next();
		}while(member<10 && continueToRegister.equalsIgnoreCase("y"));
		if(!(member<10)){
			System.out.println("���ã��Ѵﵽע���������ޣ�");
		}
	}
    public void login(){
    	System.out.println("[���͸���ϵͳ>��¼]");
		int inputTimeCount=0;	
		String name=null;
			//���û�����������������������3ʱ���ظ�ѯ��
		do{
			System.out.print("�������û�����");
		    Scanner login_name=new Scanner(System.in);
		    String loginName=login_name.next();
		    System.out.print("���������룺");
	     	Scanner login_pass=new Scanner(System.in);
		    int loginPass=login_pass.nextInt();
		    //��֤�û������Ƿ���ȷ					    
		    for (int i = 0; i < regisName.length; i++) {
				 if(loginName.equals(regisName[i]) && loginPass==regisPass[i]){
				         name=loginName;
					 System.out.println("��ӭ����"+name);					       		
				 }
			}	
		    if(name==null){
		    	 System.out.println("����������������룡");
		    	 inputTimeCount++;
		    }
		}while(name==null&&inputTimeCount<3);  
		//���������ʱ����
		if(!(inputTimeCount<3)){
			System.out.println("Sorry,�������������ᣬ���Ѵ����������Σ�");
		}	   				
	}
    public void luckyDraw(){
    	System.out.println("[���͸���ϵͳ>�齱]");				
		System.out.print("���Ŀ��ţ�");
		Scanner input_number=new Scanner(System.in);
		int number=input_number.nextInt();
						
		//�������5���������� 
		int[] luckyNO=new int[5];
		for(int i=0;i<5;i++){
			luckyNO[i]= (int)(Math.random()*10);
		    //��ѯ���˺��Ƿ��ظ�
		    for(int j=0;j<i;j++){
		    	if(luckyNO[i]==luckyNO[j]) 				    		 
		    		i--;				    	 				    	
		    }				    
		}
		//��ӡ��������
		System.out.print("���յ���������Ϊ��");
		for (int i = 0; i < luckyNO.length; i++) {
			System.out.print(luckyNO[i]+"\t");					
		} 
		//�ж��Ƿ��н�
		boolean match=false;
		for(int i=0;i<luckyNO.length;i++){
			if(number==luckyNO[i]){
				System.out.println("��ϲ�����Ǳ��յ����˻�Ա��");
				match=true;
				break;
			}				 
		}
		if(!match) //�ȼ���match==false
			System.out.println("��Ǹ�������Ǳ��յĻ�Ա��");	
    }
	public static void main(String[] args) {
		lucky myLucky=new lucky();		
		String isContinue=null;		
		do{
			//�˵�
			System.out.println("----------��ӭ���뽱�͸���ϵͳ----------");
		    System.out.println("              1.ע��");
		    System.out.println("              2.��¼");
		    System.out.println("              3.�齱");
		    System.out.println("---------------------------------------");
		    System.out.print("��ѡ��˵���");
		    Scanner input=new Scanner(System.in);
		    int userSelection=input.nextInt();
			switch(userSelection){
			case 1:
				//ע��	
				myLucky.register();
				break;
			case 2:
				//��¼
				myLucky.login();	  				    				 									 																			 
				break;
			case 3:
				//�齱��
				myLucky.luckyDraw();			
		        break;
			default:
				System.out.println("������������");
				break;
			}
			//ѯ���û��Ƿ����
			System.out.print("������(y/n):");
			Scanner yn=new Scanner(System.in);
			isContinue=yn.next();			 
		}while(isContinue.equalsIgnoreCase("y"));	//�����ִ�Сд
		System.out.println("ϵͳ�˳���ллʹ�ã�");
	}
}
