package action;

import domain.ExchangePolicy;
import service.ExchangePolicyService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class ExchangePolicyAction {
    private List<ExchangePolicy> exchangePolicyList;

    @EJB
    ExchangePolicyService exchangePolicyService;

    @PostConstruct
    public void startUp() {
        if(exchangePolicyList == null) {
            exchangePolicyList = exchangePolicyService.findAllExchangePolicies();
        }
    }

    public List<ExchangePolicy> getExchangePolicyList() {
        return exchangePolicyList;
    }

    public void setExchangePolicyList(List<ExchangePolicy> exchangePolicyList) {
        this.exchangePolicyList = exchangePolicyList;
    }
}
