import * as React from "react";
import ApiClient from "../services/ApiClient";

class BetComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            randomBet: '', 
            message: '',
            userMail: ''
        };
        this.handleSubmitResult = this.handleSubmitResult.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount(): void {
        ApiClient.bet().then(
            res => {
                if (res.ok) {
                    res.json().then(json => {
                        this.setState({
                            randomBet: json.randomBet                            
                        });
                    });
                } else {
                    this.updateMessage("Can't reach the server");
                }
            }
        );
    }

    handleChange(event) {
        const name = event.target.name;
        this.setState({
            [name]: event.target.value
        });
    }

    handleSubmitResult(event) {
        event.preventDefault();
        ApiClient.sendMail(this.state.userMail,
            this.state.randomBet).then(res => {
                if (res.ok) {
                    res.json().then(json => {
                        this.updateMessage("Apostado");
                    });
                } else {
                    this.updateMessage("Can't reach the server");
                }
            });
    }

    updateMessage(m: string) {
        this.setState({
          message: m
        });
    }

    render() {
        return (
            <div>
                <div>
                    <h3>Your new bet is</h3>
                    <h1>
                        {this.state.randomBet}
                    </h1>
                </div>
                <form onSubmit={this.handleSubmitResult}>
                    <label>
                        Your Mail:
                        <input type="text" maxLength="40"
                               name="userMail"
                               value={this.state.userMail}
                               onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Your Mail:
                        <input type="number" min="0"
                               name="userMail"
                               value={this.state.userMail}
                               onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <input type="submit" value="Submit"/>
                </form>
                <h4>{this.state.message}</h4>
            </div>
        );
    }
}

export default BetComponent;