public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void onJobPosted(JobPost jobPost) {
        System.out.println("Hi "+name+"! New job posted: "+jobPost.getTitle());
    }
}
