package cn.yxtreme.jooq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * @author: xuZeBiao
 * @since: 2021/7/27
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Accessors(chain = true)
public class BasePO {
    private Long id;
    private Boolean deleted;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Integer version;
}
