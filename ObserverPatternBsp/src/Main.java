public class Main {
    public static void main(String[] args) {
        JobSeeker vincent = new JobSeeker("Vincent");
        JobSeeker timon = new JobSeeker("Timon");
        JobSeeker guenther = new JobSeeker("Günther");

        EmploymentAgency employmentAgency = new EmploymentAgency();

        System.out.println("Vincent hinzufügen: "+employmentAgency.addObserver(vincent));
        System.out.println("Timon hinzufügen: "+employmentAgency.addObserver(timon));
        System.out.println("Günther hinzufügen: "+employmentAgency.addObserver(guenther));

        employmentAgency.addJob(new JobPost("Software Developer!"));

        System.out.print("Timon entfernen: ");
        employmentAgency.removeObserver(timon);

        employmentAgency.addJob(new JobPost("Software Tester!"));
    }
}
