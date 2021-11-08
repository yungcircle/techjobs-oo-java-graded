package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
//import org.launchcode.techjobs.oo.*;
//import org.junit.Assert;
import static org.junit.Assert.*;
/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job aJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job anotherJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Assert.assertFalse(aJob.equals(anotherJob));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", job.getId(), job.getName(), job.getEmployer(), job.getLocation(),
                job.getPositionType(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "Web Developer",
                new Employer(""),
                new Location("StL"),
                new PositionType(""),
                new CoreCompetency("Java"));
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n", job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }
}
