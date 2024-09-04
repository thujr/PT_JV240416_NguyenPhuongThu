package ra.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false)
    private String productName;
    @Column(name = "product_description", columnDefinition = "text")
    private String productDescription;
    @Column(name = "product_price",  nullable = false)
    @Min(value = 1,message = "Tiền sản phẩm phải lớn hơn 0")
    private double productPrice;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    @Column(name = "product_status", columnDefinition = "bit default 1 ")
    private boolean productStatus=true;
    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName ="category_id" )
    private Category category=new Category();
}
