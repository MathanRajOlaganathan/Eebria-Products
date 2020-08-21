import axios from 'axios';
const EEBRIA_REST_API_URL='http://localhost:8080/my-eebria/product/sort';

class EebriaService{

    getProducts(){
        return axios.get(EEBRIA_REST_API_URL, { params: { orderBy:'price',direction:'ASC'} });
    }
}

export default new  EebriaService();

