package action;

import domain.Stamp;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import service.RequestService;
import service.StampService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/14/13
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class RequestAction implements Serializable {
    private Date requestFrom, requestTo;
    private CartesianChartModel chartModel;
    private List<Stamp> stampList;

    @EJB
    RequestService requestService;

    @EJB
    StampService stampService;

    @PostConstruct
    public void startUp() {
        if (stampList == null) {
            stampList = new ArrayList<Stamp>();
        }

        if (chartModel == null) {
            chartModel = new CartesianChartModel();
        }
    }

    public String requestStatistics() {
        chartModel = new CartesianChartModel();
        ChartSeries requestCountSeries = new ChartSeries();
        requestCountSeries.setLabel("Count of Request");

        stampList = stampService.getAllStamp();
        for (Stamp stamp : stampList) {
            int requestCount = requestService.getRequestCountBetweenDates(stamp.getId(), requestFrom, requestTo).size();

            if (requestCount != 0) {
                requestCountSeries.set(stamp.getId(), requestCount);
            }
        }
        chartModel.clear();
        chartModel.addSeries(requestCountSeries);

        return "show_request_data.xhtml?redirect=true";
    }

    public Date getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(Date requestFrom) {
        this.requestFrom = requestFrom;
    }

    public Date getRequestTo() {
        return requestTo;
    }

    public void setRequestTo(Date requestTo) {
        this.requestTo = requestTo;
    }

    public List<Stamp> getStampList() {
        return stampList;
    }

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }

    public CartesianChartModel getChartModel() {
        return chartModel;
    }

    public void setChartModel(CartesianChartModel chartModel) {
        this.chartModel = chartModel;
    }
}
