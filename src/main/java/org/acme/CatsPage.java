package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Path("/")
public class CatsPage {

    static List<String> images = Arrays.asList(
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-26383-1381845104-25.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-26358-1381845043-13.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-25329-1381845415-0.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-25158-1381844793-0.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-23859-1381845509-0.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-19708-1381845008-7.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-19667-1381844937-10.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-19645-1381845207-5.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-18774-1381844645-6.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-11864-1381846346-0.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-3409-1381844582-13.gif",
        "https://raw.githubusercontent.com/pacroy/flask-app/master/gif/anigif_enhanced-buzz-3391-1381844336-26.gif"
    );

    static Random random = new Random();

    private final Template cats;

    public CatsPage(Template cats) {
        this.cats = requireNonNull(cats, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        int nextImageIndex = random.nextInt(images.size());
        return cats.data("url", images.get(nextImageIndex));
    }

}
