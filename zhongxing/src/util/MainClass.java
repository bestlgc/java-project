package util;

public class MainClass {
	//图的数据结构，Index为节点,二维数组值为边的权值。
	public static int [][]weight =  new int[18][18];
	public void init(){
		//初始化所有边的权值为10000,10000表示不连通
		for(int i=0;i<18;i++){
			for(int j=0;j<18;j++){
				weight[i][j] = 10000;
			}
		}
	}
	
	public void inputData(){
		weight[0][1] = 3;
		weight[0][2] = 1;
		weight[0][3] = 1;
		
		weight[1][0] = 3;
		weight[1][2] = 1;
		weight[1][4] = 1;
		weight[1][9] = 4;
		
		weight[2][0] = 1;
		weight[2][1] = 1;
		weight[2][3] = 1;
		weight[2][4] = 2;
		weight[2][0] = 1;
		
		weight[3][0] = 1;
		weight[3][2] = 1;
		weight[3][5] = 2;
		weight[3][6] = 2;
		weight[3][7] = 1;
		
		weight[4][1] = 1;
		weight[4][2] = 2;
		weight[4][5] = 1;
		weight[4][9] = 1;
		
		weight[5][2] = 1;
		weight[5][3] = 2;
		weight[5][4] = 1;
		weight[5][6] = 1;
		weight[5][9] = 3;
		weight[5][10] = 1;
		weight[5][12] = 3;
		
		weight[6][3] = 2;
		weight[6][5] = 1;
		weight[6][7] = 1;
		weight[6][8] = 2;
		weight[6][12] = 2;
		weight[6][13] = 4;
		weight[6][14] = 3;
		
		weight[7][3] = 1;
		weight[7][6] = 1;
		weight[7][8] = 1;
		
		weight[8][6] = 2;
		weight[8][7] = 1;
		weight[8][14] = 1;
		weight[8][15] = 3;
		
		weight[9][1] = 4;
		weight[9][4] = 1;
		weight[9][5] = 3;
		weight[9][10] = 1;
		weight[9][11] = 1;
		
		weight[10][5] = 1;
		weight[10][9] = 1;
		weight[10][11] = 1;
		weight[10][12] = 2;
		
		weight[11][9] = 1;
		weight[11][10] = 1;
		weight[11][12] = 1;
		weight[11][16] = 1;
		
		weight[12][5] = 3;
		weight[12][6] = 2;
		weight[12][11] = 1;
		weight[12][13] = 2;
		weight[12][16] = 1;
		
		weight[13][6] = 4;
		weight[13][12] = 2;
		weight[13][14] = 1;
		weight[13][15] = 2;
		weight[13][16] = 2;
		weight[13][17] = 1;
		
		weight[14][6] = 3;
		weight[14][8] = 1;
		weight[14][13] = 1;
		weight[14][15] = 1;
		
		weight[15][8] = 3;
		weight[15][13] = 2;
		weight[15][14] = 1;
		weight[15][17] = 4;
		
		weight[16][11] = 1;
		weight[16][12] = 1;
		weight[16][13] = 2;
		weight[16][17] = 1;
		
		weight[17][13] = 1;
		weight[17][15] = 4;
		weight[17][16] = 1;
	}
	
}
