package factory.settings;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class EdgeSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions settings(String... optionArgs) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(optionArgs);
        return options;
    }
}
