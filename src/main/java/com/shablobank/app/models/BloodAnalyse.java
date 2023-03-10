package com.shablobank.app.models;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tblood_analyse")
@Data
public class BloodAnalyse  implements Serializable {
  private static final long serialVersionUID = -4612504723628291981L;

  @EmbeddedId
  private BloodAnalyseKey id;

  @ManyToOne()
  @MapsId("bloodId")
  @JoinColumn(name="analyse_id")
  private Analyse analyses;

  @ManyToOne()
  @MapsId("analyseId")
  @JoinColumn(name="blood_id")
  private Bloods blood;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = true)
  private Date updatedAt;
}
