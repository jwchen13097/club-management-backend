package com.tw.clubmanagement.entity;

import com.tw.clubmanagement.model.Activity;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_activity")
@Builder
public class ActivityEntity extends BaseEntity {
    private Integer clubId;
    private String name;
    private String themePicture;
    private Date startTime;
    private Date endTime;
    private Date joinEndTime;
    private Integer numberLimitation;
    private String description;
    private Integer status;
    private Integer numberThumbsUp;

    public Activity toActivity() {
        return Activity.builder()
                .id(id)
                .clubId(clubId)
                .name(name)
                .themePicture(themePicture)
                .startTime(startTime)
                .endTime(endTime)
                .joinEndTime(joinEndTime)
                .numberLimitation(numberLimitation)
                .description(description)
                .status(status)
                .numberThumbsUp(numberThumbsUp)
                .build();
    }

    public static ActivityEntity fromActivity(Activity activity) {
        ActivityEntity activityEntity = ActivityEntity.builder()
                .clubId(activity.getClubId())
                .name(activity.getName())
                .themePicture(activity.getThemePicture())
                .startTime(activity.getStartTime())
                .endTime(activity.getEndTime())
                .joinEndTime(activity.getJoinEndTime())
                .numberLimitation(activity.getNumberLimitation())
                .description(activity.getDescription())
                .status(activity.getStatus())
                .numberThumbsUp(activity.getNumberThumbsUp())
                .build();
        activityEntity.setId(activity.getId());
        return activityEntity;
    }
}
