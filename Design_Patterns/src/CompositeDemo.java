class CompositeDemo {
    public static void run() {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        GraphicGroup group = new GraphicGroup();
        group.add(c1);
        group.add(c2);
        System.out.println("[Composite] Drawing group:");
        group.draw();
    }
}
