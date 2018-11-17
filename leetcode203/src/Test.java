public interface Test {
    public void A();
    public void B();
    public void C();
    default public void D(){
        System.out.println("NIhapo");
    };

}
