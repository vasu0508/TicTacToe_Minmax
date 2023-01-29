package com.mycompany.tictactoe;
/**
 *
 * @author Vasu
*/
public class MinMax{
  int move(int[] arr,int move){
      if(!isfull(arr)){
      int m=0,score,max=-1000,min=1000;
      for(int i=0;i<9;i++){
          if(isAvailable(arr,i)){
              m=i;
              break;
          }
      }
      if(move==1){
        for(int i=0;i<9;i++){
            int[] arr1=arr;
            if(isAvailable(arr1,i)){
                m=i;
                arr1[i]=move;
                score=minmax(arr1,1,0);
                if(evaluate(arr1)==10){
                    return i;
                }
                arr[i]=0;
                if(score>max){
                    max=score;
                    m=i;
                }
            }
        }
        return m;
      }
      else{
          for(int i=0;i<9;i++){
            int[] arr1=arr;
            if(isAvailable(arr1,i)){
                arr1[i]=move;
                score=minmax(arr1,0,0);
                if(evaluate(arr1)==-10){
                    return i;
                }
                arr[i]=0;
                if(score<min){
                    min=score;
                    m=i;
                }
            }
        }
          return m;
      }
      }
      else{
          return 0;
      }
  }
  int minmax(int[] arr,int maxmin,int depth){
      int max=-20,min=20,moveposition=0;
      if(maxmin==0){
        int move=1;  
        for(int i=0;i<9;i++){
            int[] arr1=arr;
            if(isAvailable(arr1,i)){
                arr1[i]=move;
                int score=evaluate(arr1);
                if(score==-1000){
                    score=minmax(arr1,1,depth+1);
                }
                arr1[i]=0;
                if(max<(score-depth)){
                    max=score-depth;
                    moveposition=i;
                }
            }  
            
        }
        
        return max; 
      }
      else{
          int move=2;
          for(int i=0;i<9;i++){
            int[] arr1=arr;
            if(isAvailable(arr1,i)){
                arr1[i]=move;
                int score=evaluate(arr1);
                if(score==-1000){
                    score=minmax(arr1,0,depth+1);
                }
                arr1[i]=0;
                if(min>(score+depth)){
                    min=score+depth;
                    moveposition=i;
                }
            }  
          }
          return min;
      }
  }
boolean isfull(int[] arr){
   if(arr[0]!=0 && arr[1]!=0 && arr[2]!=0 && arr[3]!=0 && arr[4]!=0 && arr[5]!=0 && arr[6]!=0 && arr[7]!=0 && arr[8]!=0){
        return true;
    } 
   else{
       return false;
   }
}
int evaluate(int[]arr){
            if(((arr[0]==1 && arr[1]==1 && arr[2]==1) || (arr[3]==1 && arr[4]==1 && arr[5]==1) || (arr[6]==1 && arr[7]==1 && arr[8]==1)
                    || (arr[0]==1 && arr[3]==1 && arr[6]==1) || (arr[1]==1 && arr[4]==1 && arr[7]==1) || (arr[2]==1 && arr[5]==1 && arr[8]==1)
                    || (arr[0]==1 && arr[4]==1 && arr[8]==1) || (arr[2]==1 && arr[4]==1 && arr[6]==1))){
                return 10;
            }
            else if(((arr[0]==2 && arr[1]==2 && arr[2]==2) || (arr[3]==2 && arr[4]==2 && arr[5]==2) || (arr[6]==2 && arr[7]==2 && arr[8]==2)
                    || (arr[0]==2 && arr[3]==2 && arr[6]==2) || (arr[1]==2 && arr[4]==2 && arr[7]==2) || (arr[2]==2 && arr[5]==2 && arr[8]==2)
                    || (arr[0]==2 && arr[4]==2 && arr[8]==2) || (arr[2]==2 && arr[4]==2 && arr[6]==2))){
                return -10;
            }
            else if(arr[0]!=0 && arr[1]!=0 && arr[2]!=0 && arr[3]!=0 && arr[4]!=0 && arr[5]!=0 && arr[6]!=0 && arr[7]!=0 && arr[8]!=0){
                return 0;
            }
            else{
                return -1000;
            }
    }
    boolean isAvailable(int[] arr,int moveposition){
        if(arr[moveposition]==0){
            return true;
        }
        else{
            return false;
        }
    }  
}
