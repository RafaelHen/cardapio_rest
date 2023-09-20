import axios, {AxiosPromise} from "axios"
import { FoodData } from "../interface/FoodData";
import { useMutation, useQueryClient } from "@tanstack/react-query";

const API_URL = 'http://localhost:8080/'

const postData = async(data:FoodData): AxiosPromise<unknown> => {
    const response = axios.post(API_URL + 'food', data );
    return response;
}

export function useFoodDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData, // função para fazer o fetch dos dados.
        retry: 2,
        onSuccess: () =>{
            queryClient.invalidateQueries(['food-data']); //invalidar os get anteriores do useFood e atualizar pelo novo
        }
    })
    return mutate
}