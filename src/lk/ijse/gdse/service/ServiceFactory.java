package lk.ijse.gdse.service;

import lk.ijse.gdse.service.custom.impl.ReservationServiceImpl;
import lk.ijse.gdse.service.custom.impl.RoomServiceImpl;
import lk.ijse.gdse.service.custom.impl.StudentServiceImpl;
import lk.ijse.gdse.service.custom.impl.UserServiceImpl;
import lk.ijse.gdse.service.util.ServiceType;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance() {
        return serviceFactory == null ? (serviceFactory = new ServiceFactory()) : serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentServiceImpl();
            case ROOM:
                return (T) new RoomServiceImpl();
            case RESERVATION:
                return (T) new ReservationServiceImpl();
            case USER:
                return (T) new UserServiceImpl();
            default: throw new RuntimeException("Service not found");
        }
    }
}
