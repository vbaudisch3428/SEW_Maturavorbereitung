class ObserverDemo {
    public static void run() {
        NewsAgency agency = new NewsAgency();
        agency.addObserver(new NewsSubscriber("Alice"));
        agency.addObserver(new NewsSubscriber("Bob"));
        agency.notifyObservers("New Java version released!");
    }
}