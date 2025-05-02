class NewsSubscriber implements Observer {
    private String name;
    public NewsSubscriber(String name) { this.name = name; }
    public void update(String msg) {
        System.out.println("[Observer] " + name + " received news: " + msg);
    }
}