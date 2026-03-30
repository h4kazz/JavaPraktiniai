import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PhilatelistBaseTest;
import lt.techin.philatelist.PostStamp;

import java.util.List;

public class PhilatelistTest extends PhilatelistBaseTest {
    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImpl() {};
    }
}
