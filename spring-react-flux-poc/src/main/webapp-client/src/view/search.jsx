import React from "react";
import Menu from "../components/Menu.jsx";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";
import FrameworkTable from "../components/FrameworkTable.jsx";


class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            active: 3,
            frameworks: [],
            onSubmit: this.onSubmit
        };
    }

    componentDidMount() {
        this.unsubscribe = FrameworkStore.listen(this.onStatusChange.bind(this));
        FrameworkAction.getFrameworks();
    }

    componentWillUnmount() {
        this.unsubscribe();
    }

    onStatusChange(state) {
        this.setState(state);
    }

    handleChange(event) {
        
        FrameworkAction.searchFrameworks(event.target.value);
    }

    render() {
        return (
            <div className="row">
                <Menu  {...this.state}/>

                <div className="col-md-8">
                    <div className="well">
                        <form>
                            <label>Framework Search</label>
                            <div className="input-group">
                                <input className="form-control"
                                    type="text"
                                    value={this.state.value}
                                    onChange={this.handleChange}
                                />
                            </div>
                        </form>
                    </div>
                    <FrameworkTable {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Home;