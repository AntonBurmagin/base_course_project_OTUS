package exceptions;

public class PagePathAnnotationNotFoundException extends RuntimeException {
    public PagePathAnnotationNotFoundException() {
        super("Annotation path not found!");
    }
}
