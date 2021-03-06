package abfbe.domain;

import abfbe.utils.Props;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Date: 20/08/15
 *
 * @author mauret
 *         <p>
 *         Maps a menu entruy for a {@link Menu}
 */
@Entity
public class MenuEntry extends DomainObject {
    private static final long serialVersionUID = 6839784953940207821L;
    private Long idMenuEntry;
    private String name;
    private List<Menu> menus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdMenuEntry() {
        return idMenuEntry;
    }

    public void setIdMenuEntry(final Long idMenuEntry) {
        this.idMenuEntry = idMenuEntry;
    }

    @NotNull
    @Size(min = Props.MIN_LENGTH, max = Props.MENU_ENTRY_NAME_LENGTH)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @ManyToMany
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(final List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof MenuEntry && this.idMenuEntry.equals(((MenuEntry) obj)
                .getIdMenuEntry());
    }
}
