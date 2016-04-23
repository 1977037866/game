package game;
import java.util.Scanner;
public class lucky {
	public static void main(String[] args) {
		String[] regisName=new String[10];
		int[] regisPass=new int[10];
		int[] vipNo=new int[10];
		int member=0;
		String isContinue=null;
		String continueToRegister=null;
		do{
			//菜单
			System.out.println("----------欢迎进入奖客富翁系统----------");
		    System.out.println("              1.注册");
		    System.out.println("              2.登录");
		    System.out.println("              3.抽奖");
		    System.out.println("---------------------------------------");
		    System.out.print("请选择菜单：");
		    Scanner input=new Scanner(System.in);
		    int userSelection=input.nextInt();
			switch(userSelection){
			case 1:
				//注册	
				//允许用户一次注册一个或多个
				do{
					System.out.println("[奖客富翁系统>注册]");	
				    System.out.println("请填写个人注册信息：");				 				 
					System.out.print("用户名：");
				    Scanner regis_name=new Scanner(System.in);
				    regisName[member]=regis_name.next();				
				    System.out.print("密码：");
				    Scanner regis_pass=new Scanner(System.in);
				    regisPass[member]=regis_pass.nextInt();				    
				    //随机生成1位整数作为会员卡号
				    vipNo[member]=(int)(Math.random()*10);			     	 
				    System.out.println("注册成功，请记号您的会员卡号");
			    	System.out.println("用户名\t密码\t会员卡号");
			    	System.out.println(regisName[member]+"\t"+regisPass[member]+"\t"+vipNo[member]);
			    	member++;
			    	System.out.print("继续注册吗？（y/n）");
			    	Scanner input_1=new Scanner(System.in);
			    	continueToRegister=input_1.next();
				}while(member<10 && continueToRegister.equalsIgnoreCase("y"));
				if(!(member<10)){
					System.out.println("您好，已达到注册人数上限！");
				}
				break;
			case 2:
				//登录
				System.out.println("[奖客富翁系统>登录]");
				int inputTimeCount=0;	
				String name=null;
 				//当用户输入错误且输入次数不大于3时，重复询问
				do{
					System.out.print("请输入用户名：");
				    Scanner login_name=new Scanner(System.in);
				    String loginName=login_name.next();
				    System.out.print("请输入密码：");
			     	Scanner login_pass=new Scanner(System.in);
				    int loginPass=login_pass.nextInt();
				    //验证用户输入是否正确	
				    
				    if(loginName.equals(regisName[member]) && loginPass==regisPass[member]){
 					        name=loginName;				            				           
				    }else{
				    	    member++;
				    }  				    
				    if(!(name==null))			    	
				        System.out.println("欢迎您："+name);
				    else{
			        	inputTimeCount++;					       					        
				    	System.out.println("输入错误，请重新输入！");
				    }
				}while(name==null&&member<regisName.length&&inputTimeCount<3);  
				if(!(inputTimeCount<3)){
					System.out.println("Sorry,最多三次输入机会，您已错误输入三次！");
				}	   					  				    				 									 																			 
				break;
			case 3:
				//抽奖
				System.out.println("[奖客富翁系统>抽奖]");
				System.out.print("您的卡号：");
				Scanner input_number=new Scanner(System.in);
				int number=input_number.nextInt();
				//随机产生5个幸运数字 
				int[] luckyNO=new int[5];
				for(int i=0;i<5;i++){
					luckyNO[i]= (int)(Math.random()*10);
				    //查询幸运号是否重复
				    for(int j=0;j<i;j++){
				    	if(luckyNO[i]==luckyNO[j]) 				    		 
				    		i--;				    	 				    	
				    }				    
				}
				//打印幸运数字
				System.out.print("本日的幸运数字为：");
				for (int i = 0; i < luckyNO.length; i++) {
					System.out.println(luckyNO[i]+"\t");
				}
				//判断是否中奖
				boolean match=false;
				for(int i=0;i<luckyNO.length;i++){
					if(number==luckyNO[i]){
						System.out.print("恭喜！您是本日的幸运会员！");
						match=true;
						break;
					}				 
				}
				if(!match) //等价于b==false
					System.out.println("抱歉！您不是本日的会员！");				
		        break;
			default:
				System.out.println("您的输入有误！");
				break;
			}
			//询问用户是否继续
			System.out.print("继续吗？(y/n):");
			Scanner yn=new Scanner(System.in);
			isContinue=yn.next();			 
		}while(isContinue.equalsIgnoreCase("y"));	//不区分大小写
		System.out.println("系统退出，谢谢使用！");
	}
}
