package api.config;

import services.*;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },
    GET_TIME {
        @Override
        public Class<?> getEntityService() {
            return GetTimeService.class;
        }
    },
    ADD_TIME {
        @Override
        public Class<?> getEntityService() {
            return AddTimeService.class;
        }
    },
    EDIT_TIME {
        @Override
        public Class<?> getEntityService() {
            return EditTimeService.class;
        }
    },
    DELETE_TIME {
        @Override
        public Class<?> getEntityService() {
            return DeleteTimeService.class;
        }
    };

    public abstract Class<?> getEntityService();
}



