import React from 'react';
import Time from 'react-time';

const FrameworkDetail = (props) => {

    let framework = props.framework;

    return (
        <div className="well">
            <div className="row">
                <div className="col-md-2" title="Back" onClick={props.backFce}>
                    <a title="Back">
                        <i className="fa fa-arrow-circle-left fa-3x"/>
                    </a>
                </div>
            </div>
            <h3>{framework.name}</h3>
            <div className="row">
                <div className="col-md-2">
                    <h4>Added on:</h4>
                </div>
                <div className="col-md-10">
                    <p><Time value={framework.addedOn} format="DD-MM-YYYY" /></p>
                </div>
            </div>
            <div className="row">
                <div className="col-md-2">
                    <h4>Category:</h4>
                </div>
                <div className="col-md-10">
                    <p>{framework.category.name}</p>
                </div>
            </div>
            <div className="row">
                <div className="col-md-2">
                    <h4>Doc link:</h4>
                </div>
                <div className="col-md-10">
                    <a href={framework.documentationLink}>{framework.documentationLink}</a>
                </div>
            </div>
            <div className="row">
                <div className="col-md-2">
                    <h4>Description:</h4>
                </div>
                <div className="col-md-10">
                    <p>{framework.description}</p>
                </div>
            </div>
        </div>
    );
};

FrameworkDetail.propTypes = {
    framework: React.PropTypes.object,
    backFce: React.PropTypes.func
};

export default FrameworkDetail;