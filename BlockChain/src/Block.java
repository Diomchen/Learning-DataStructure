
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Block {
    private int index;//区块编号
    private long timestamp;//区块时间戳
    private String prevBlockHash;//上一个区块哈希值
    private String hash;//当前区块值

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    private String data;//区块数据

    public Block(){
        this.index = 0;
        this.timestamp = System.currentTimeMillis();
        this.prevBlockHash = prevBlockHash;
        try {
            this.hash = calculateHash(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Maybe sth wrong!");
        }
        this.data = data;
    }

    public String calculateHash(Block b) throws NoSuchAlgorithmException {
        StringBuilder  blockData = null;
        blockData.append(b.index);
        blockData.append(b.timestamp);
        blockData.append(b.prevBlockHash);
        blockData.append(b.data);
        String s = blockData.toString();
        System.out.println(s);

        //java 8+
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
//        String calcRes = Base64.getEncoder().encodeToString(hash);
        String calcRes = getSha256(s);
        return calcRes;

    }

    public Block generateBlock(Block prevBlock, String data){
        Block newBlock = new Block();
        newBlock.index = prevBlock.index + 1;
        newBlock.prevBlockHash = prevBlock.hash;
        newBlock.timestamp = System.currentTimeMillis();
        try {
            newBlock.hash = calculateHash(newBlock);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        newBlock.data = data;

        return newBlock;
    }

    public Block generrateGenesisBlock(){
        Block GBlock = new Block();
        GBlock.index = -1;
        GBlock.hash = "";
        return generateBlock(GBlock,"Genesis Block");
    }

    private static String getSha256(String value) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}
