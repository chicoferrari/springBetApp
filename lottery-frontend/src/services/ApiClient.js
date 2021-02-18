class ApiClient {

    static SERVER_URL = 'http://localhost:8080';
    static GET_BET = '/bet';
    static POST_EMAIL = '/aposta';

    static bet(): Promise<Response> {
        return fetch(ApiClient.SERVER_URL + ApiClient.GET_BET);
    }

    static sendMail(randomBet: list,
                    userMail: string): Promise<Response> {
        return fetch(ApiClient.SERVER_URL + ApiClient.POST_EMAIL,
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(
                    {
                        userMail: userMail,
                        randomBet: randomBet                        
                    }
                )
            });
    }
}

export default ApiClient;