package DiamondShop.Service.User;

import DiamondShop.Dto.PaginatesDto;
import org.springframework.stereotype.Service;

@Service
public interface IPaginateService {
    public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
