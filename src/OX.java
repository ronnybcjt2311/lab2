public class OX {
    public String player;
    private String[][] table = {
            {" " ,"0" ,"1" ,"2" },
            {"0" ,"-" ,"-" ,"-" },
            {"1" ,"-" ,"-" ,"-" },
            {"2" ,"-" ,"-" ,"-" },
    };


    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public OX(){
        player = "X";
        turnCount = 0;
        scoreX = 0;
        scoreO = 0;
        scoreDraw =0;
    }

    public String getTableString() {
        String result = "";
        for(int row=0 ; row<table.length ; row++ ){
            for(int col=0 ; col<table[row].length ; col++ ){
                result = result + table[row][col];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public boolean put(int row, int col) {
        try {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            } else {
                table[row + 1][col + 1] = getCurrentPlayer();
                turnCount++;
                if(checkWin(row,col)){
                    if(player.equals("X")){
                        scoreX++;
                    }else if(player.equals("O")){
                        scoreO++;
                    }
                }
                if(isDraw()){
                    scoreDraw++;
                }
                return true;
            }
        }catch (Exception ex){
            return false;
        }

    }

    public void switchPlayer() {
        OX ox = new OX();
        if(player.equals("X")) {
            player = "O";
        }else{
            player = "X";
        }
    }

    public boolean checkWin(int row, int col) {

        boolean rowWin = true;
        for(int i=0;i<3;i++){
            if(!table[row+1][i+1].equals(player)){
                rowWin=false;
            }
        }
        if(rowWin){
            return true;
        }

        boolean colWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][col+1].equals(player)){
                colWin=false;
            }
        }
        if(colWin){
            return true;
        }

        boolean esWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][i+1].equals(player)){
                esWin=false;
            }
        }
        if(esWin){
            return true;
        }

        boolean ssWin = true;
        for(int i=0;i<3;i++){
            if(!table[i+1][3-i].equals(player)){
                ssWin=false;
            }
        }
        if(ssWin){
            return true;
        }

        return false;
    }

    public void reset() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                table[i+1][j+1]="-";
            }
        }
        player = "X";
        turnCount = 0;
    }

    public int getTurnCount() {

        return turnCount;
    }

    public boolean isDraw() {
        if(turnCount < 9){
            return false;
        }
        return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}
