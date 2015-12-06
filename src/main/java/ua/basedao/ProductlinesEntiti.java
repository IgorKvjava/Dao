package ua.basedao;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by liny on 06.12.15.
 */
@Entity
@Table(name = "productlines", schema = "classicmodels")
public class ProductlinesEntiti {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;

    @Id
    @Column(name = "productLine")
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Basic
    @Column(name = "textDescription")
    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Basic
    @Column(name = "htmlDescription")
    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductlinesEntiti that = (ProductlinesEntiti) o;

        if (productLine != null ? !productLine.equals(that.productLine) : that.productLine != null) return false;
        if (textDescription != null ? !textDescription.equals(that.textDescription) : that.textDescription != null)
            return false;
        if (htmlDescription != null ? !htmlDescription.equals(that.htmlDescription) : that.htmlDescription != null)
            return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productLine != null ? productLine.hashCode() : 0;
        result = 31 * result + (textDescription != null ? textDescription.hashCode() : 0);
        result = 31 * result + (htmlDescription != null ? htmlDescription.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
