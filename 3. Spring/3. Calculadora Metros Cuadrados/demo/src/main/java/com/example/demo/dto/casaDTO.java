package com.example.demo.dto;

import java.util.List;

public class casaDTO {
        private String name;
        private String address;
        private List<cuartoDTO> rooms;

        public casaDTO() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public List<cuartoDTO> getRooms() {
                return rooms ;
        }

        public void setRooms(List<cuartoDTO> rooms) {
                this.rooms = rooms;
        }
}
