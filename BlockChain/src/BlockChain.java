import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    public static List<Block> blockList = new ArrayList<>();

    public static void addBlock(Block newBlock) throws NoSuchAlgorithmException {
        Block oldBlock = blockList.get(blockList.size() - 1);
        if(isValid(newBlock,oldBlock)){
            blockList.add(newBlock);
        }
        else{
            System.out.println("Invalid Block.");
        }
    }

    public static boolean isValid(Block newBlock , Block oldBlock) throws NoSuchAlgorithmException {
        if(newBlock.getIndex() != oldBlock.getIndex()+1)
            return false;
        if(newBlock.getPrevBlockHash() != oldBlock.getHash())
            return false;
        if(newBlock.getHash() != newBlock.calculateHash(newBlock))
            return false;
        return true;
    }

    public static Block makeNewBlock(){
        return (new Block()).generrateGenesisBlock();
    }

    public static void sendData(String data) throws NoSuchAlgorithmException {
        Block preBlock = blockList.get(blockList.size()-1);
        Block newBlock = (new Block()).generateBlock(preBlock,data);
        addBlock(newBlock);
    }

    public static void printBlock(){
        System.out.println("{");
        for(Block b:blockList){
            System.out.println("\t{");
            System.out.println("index:"+b.getIndex());
            System.out.println("preBlockHash:"+b.getPrevBlockHash());
            System.out.println("hash:"+b.getHash());
            System.out.println("data:"+b.getData());
            System.out.println("\t}");
        }
        System.out.println("}");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Block genesis = makeNewBlock();
        sendData("send 1 BTC to Jack");
        sendData("send 10 BTC to Jack");
        sendData("send 100 BTC to Jack");
        printBlock();
    }

}


