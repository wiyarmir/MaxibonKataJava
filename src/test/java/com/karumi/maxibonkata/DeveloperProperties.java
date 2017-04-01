package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

    private static final String ANY_NAME = "Rich King Of The North";
    private static final int ANY_NUMBER = 0;

    @Before
    public void setUp() {
    }

    @Property
    public void numberOfMaxibons(@From(DevelopersGenerator.class) Developer developer) {
        assertThat(developer, is(notNullValue()));
        assertThat(developer.getName(), is(notNullValue()));
        assertThat(developer.getNumberOfMaxibonsToGrab(), is(greaterThanOrEqualTo(0)));
    }

    @Property
    public void numberOfMaxibon(int number) {
        Developer developer = new Developer(ANY_NAME, number);

        assertThat(developer.getNumberOfMaxibonsToGrab(), is(greaterThanOrEqualTo(0)));
    }

    @Property
    public void nameOfDeveloper(String name) {
        Developer developer = new Developer(name, ANY_NUMBER);

        assertThat(developer.getName(), is(equalTo(name)));
    }
}
