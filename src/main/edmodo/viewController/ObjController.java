package edmodo.viewController;

import com.edmodo.Main;

/**
 * Created by pc on 29.01.2017.
 */
public abstract class ObjController {

    private Main main;

    public ObjController() {
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

}
