#include <stdio.h>

int main(){
	int y,m,d;
	int md[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	int mdr[12]={31,29,31,30,31,30,31,31,30,31,30,31};
	while(1){
		int i,res=0;
		scanf("%d %d %d",&y,&m,&d);
		if(y%400==0||(y%4==0&&y%100!=0)){ //閏年
			for(i=0;i<m-1;i++){
				res+=mdr[i];
			}
			res+=d;
			printf("%d",res);
		}
		else{ //平年
			for(i=0;i<m-1;i++){
				res+=md[i];
			}
			res+=d;
			printf("%d",res);
		}
	}
}
