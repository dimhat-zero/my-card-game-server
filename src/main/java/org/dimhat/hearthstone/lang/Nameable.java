package org.dimhat.hearthstone.lang;

/**
 * 可命名抽象类
 */
public abstract class Nameable {

    public Nameable(Integer id, String title, String description, String explain, Integer patternId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.explain = explain;
        this.patternId = patternId;
    }

    private Integer id;

    /*标题*/
    private String title;

    /*描述*/
    private String description;

    /*台词*/
    private String explain;

    /*图片*/
    private Integer patternId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }
}
